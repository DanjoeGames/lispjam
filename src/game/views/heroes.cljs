(ns game.views.heroes
  (:require [reagent.core :as reagent]
            [secretary.core :refer [dispatch!]]
            [game.state :as state]
            [game.ui.widgets :as widgets :refer [button icon]]
            [game.ui.hero :as hero]
            [game.ui.item :as item]
            [game.util.core :as util]
            [game.procedural.hero :refer [generate]]))

(defn action-bar []
  [:div {:class "ui action-bar"}
   [button "Hunt"   {:on-click #(dispatch! "/hunt")} "red"]
   [button "League" {:on-click #(dispatch! "/league")} "blue"]
   [button "Shop"   {:on-click #(dispatch! "/shop")} "green"]])

(defn id->hero [id]
  (state/get-in [:heroes id]))

(defn my-heroes []
  (map id->hero (state/get :my-heroes)))

(defn main []
  [:main
   [widgets/navbar "Heroes"]
   [hero/list (my-heroes)]
   [widgets/overlay {:showing? false}
     [widgets/scroll
      [:h2 "Victory!"]
      [:p "The wandering yeti didn't stand a chance"]
      [button "Quit" nil "red"]
      [button "Continue" nil "yellow"]]]
   [widgets/action-bar]])

