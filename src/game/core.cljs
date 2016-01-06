(ns game.core
  (:require [reagent.core :as reagent :refer [atom]]
            [secretary.core :as secretary :refer-macros [defroute]]
            [game.state :as state]
            [game.views.heroes :as heroes-view]
            [game.views.hunt :as hunt-view]
            [game.views.league :as league-view]))

(enable-console-print!)

(defroute "/league" []
  (state/put! :view :league))
(defroute "/hunt" []
  (state/put! :view :hunt))
(defroute "/*" []
  (state/put! :view :heroes))

(defn app []
  [:div
    [(case (state/get :view)
       :heroes heroes-view/main
       :hunt hunt-view/main
       :league league-view/main
       heroes-view/main)]])

(reagent/render-component
  [app]
  (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
