(ns game.views.league
  (:require [reagent.core :as reagent]
            [secretary.core :refer [dispatch!]]))

(defn main []
  [:h1 "League"
    [:nav
      [:button {:on-click #(dispatch! "/heroes")} "Heroes"]
      [:button {:on-click #(dispatch! "/hunt")} "Hunt"]]])
