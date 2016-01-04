(ns game.core
  (:require [reagent.core :as reagent :refer [atom]]
            [secretary.core :as secretary :refer-macros [defroute]]
            [devcards.core :as dc]
            [game.battle :as battle]
            [game.ui.widgets :as wid]
            [game.state :as state]
            [game.views.heroes :as heroes-view]
            [game.views.hunt :as hunt-view]
            [game.views.league :as league-view])
  (:require-macros [devcards.core :refer [defcard]]))

(enable-console-print!)
(devcards.core/start-devcard-ui!)

(defroute "*" []
  (state/put! :view heroes-view/main))
(defroute "/league" []
  (state/put! :view league-view/main))
(defroute "/hunt" []
  (state/put! :view hunt-view/main))

(defn app []
  [(state/get :view)])

(defn hook-browser-navigation! []
  (.addEventListener
    js/window
    "hashchange"
    (fn [e]
      (let [location (-> js/window .-location .-hash)
            route (.slice location 1)]
        (secretary/dispatch! route)))))

(defn init! []
  (secretary/set-config! :prefix \#)
  (hook-browser-navigation!))
;;  #_(reagent/render-component
;;    [app]
;;    (. js/document (getElementById "app"))))

(init!)

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)

(defn hello [name]
  [:h1 name])

(defcard hello-world
  (reagent/as-element [hello "World"]))

(defcard item-slot 
  (reagent/as-element 
    (wid/item-slot 
      {:src "/assets/item_slot.png" :name "placeholder" :width "50" :height "50"})))

(defcard item-slot 
  (reagent/as-element 
    (wid/item-list 
      (for [x (range 4)] {:name x :src "assets/item_slot.png"}))))

(defcard hp-bar 
  (reagent/as-element 
    (wid/hp-bar 5 5)))

(defcard battle 
  (reagent/as-element 
    [:h1 ((battle/resolveBattle [{:attack 10 :role "defence" :toughness 8 :hp 100}] {:attack 10 :toughness 8 :hp 100}) :winner)]))

