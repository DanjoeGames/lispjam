(ns game.views.hunt
  (:require [reagent.core :as reagent]
            [secretary.core :refer [dispatch!]]))

(defn main []
  [:h1 "Hunt"
    [:nav
      [:button {:on-click #(dispatch! "/heroes")} "Heroes"]
      [:button {:on-click #(dispatch! "/league")} "League"]]])
