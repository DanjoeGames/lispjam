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

(defn monster-preview [monster]
  [:div {:class "hz-preview"}
   [:div {:class "hz-preview__left"}
    [:div {:class "ui hz-preview__left__top"}]
    [:div {:class "ui hz-preview__left__middle"}
     [:img {:src ""}]]
    [:div {:class "ui hz-preview__left__bottom"}]]
   [:div {:class "hz-preview__right"}
    [:div {:class "ui hz-preview__right__top"}]
    [:div {:class "ui hz-preview__right__middle"}
     [:div {:class "hz-preview__level"}
      [widgets/level (:level monster)]]
     [:strong (:name monster)]
     [:p "This fearsome monster is not very tall"]
     [item/slots [] 3]]
    [:div {:class "ui hz-preview__right__bottom"}]]])

(defn main []
  [:main
   [widgets/navbar
    [widgets/money 110044]]
   [hero/list
    [{:name "Dan" :level 9 :xp 3 :hp 4 :items []}
     {:name "Ed" :level 2 :xp 2 :hp 5 :items []}
     {:name "Joe" :level 19 :xp 5 :hp 3 :items []}]]
   [monster-preview {:name "Medusa" :level 65}]
   [widgets/overlay {:showing? false}
     [widgets/scroll
      [:h2 "Victory!"]
      [:p "The wandering yeti didn't stand a chance"]
      [button "Quit" nil "red"]
      [button "Continue" nil "yellow"]]]
   [action-bar]])

