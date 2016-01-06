(ns game.core
  (:require
            [game.battle :as battle]
            [game.ui.widgets :as wid]
            [game.state :as state]
            [game.views.heroes :as heroes-view]
            [game.views.hunt :as hunt-view]
            [game.views.league :as league-view]
            [game.models.hero :refer [skins hair clothes]]
            [game.procedural.hero :as hero]))

(enable-console-print!)

(println skins)
(println hair)
(println clothes)

(defn app []
  [:div
    [(state/get :view)]])

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)


