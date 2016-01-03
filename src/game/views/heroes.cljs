(ns game.views.heroes
  (:require [reagent.core :as reagent]
            [secretary.core :refer [dispatch!]]
            [game.ui.widgets :as widgets :refer [button icon]]
            [game.ui.hero :as hero]
            [game.ui.item :as item]
            [game.util.core :as util]))

(defn action-bar []
  [:div {:class "ui action-bar"}
   [button "Hunt"   {:on-click #(dispatch! "/hunt")} "red"]
   [button "League" {:on-click #(dispatch! "/league")} "blue"]
   [button "Shop"   {:on-click #(dispatch! "/shop")} "green"]])

(defn main []
  [:main
   [widgets/navbar "Heroes"]
   [hero/list
    [{:name "Dan" :level 9 :xp 3 :hp 4 :items []}
     {:name "Ed" :level 2 :xp 2 :hp 5 :items []}
     {:name "Joe" :level 19 :xp 5 :hp 3 :items []}]]
   [widgets/overlay {:showing? false}
     [widgets/scroll
      [:h2 "Victory!"]
      [:p "The wandering yeti didn't stand a chance"]
      [button "Quit" nil "red"]
      [button "Continue" nil "yellow"]]]
   [widgets/action-bar]])

