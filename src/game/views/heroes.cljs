(ns game.views.heroes
  (:require [reagent.core :as reagent]
            [secretary.core :refer [dispatch!]]))

(defn main []
  [:main
    [:h1 "Heroes"]
    [:nav
      [:button {:on-click #(dispatch! "/league")} "League"]
      [:button {:on-click #(dispatch! "/hunt")} "Hunt"]]])

