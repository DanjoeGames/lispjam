(ns game.core
  (:require [reagent.core :as reagent :refer [atom]]
            [secretary.core :as secretary :refer-macros [defroute]]
            [devcards.core :as dc]
            [game.state :as state]
            [game.views.heroes :as heroes-view]
            [game.views.hunt :as hunt-view]
            [game.views.league :as league-view])
  (:require-macros [devcards.core :refer [defcard]]))

(enable-console-print!)
;;(devcards.core/start-devcard-ui!)

(defroute "*" []
  (state/put! :view heroes-view/main))
(defroute "/league" []
  (state/put! :view league-view/main))
(defroute "/hunt" []
  (state/put! :view hunt-view/main))

(defn app []
  [:div
    [(state/get :view)]])

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
  (hook-browser-navigation!)
  (reagent/render-component
    [app]
    (. js/document (getElementById "app"))))

(init!)

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
