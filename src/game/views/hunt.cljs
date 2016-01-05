(ns game.views.hunt
  (:require [reagent.core :as reagent]
            [secretary.core :refer [dispatch!]]
            [game.state :as state]
            [game.ui.widgets :as widgets :refer [button icon]]
            [game.ui.item :as item]
            [game.ui.hero :refer [sprite]]))

(defn action-bar []
  [:div {:class "ui action-bar"}
   [button "Heroes" {:on-click #(dispatch! "/heroes")} "yellow"]
   [button "League" {:on-click #(dispatch! "/league")} "blue"]
   [button "Shop"   {:on-click #(dispatch! "/shop")} "green"]])

(defn monster-preview
 ([monster]
  (monster-preview nil monster))
 ([k monster]
   [:div {:key k
          :class "hz-preview"}
    [:div {:class "hz-preview__left"}
     [:div {:class "ui hz-preview__left__top"}]
     [:div {:class "ui hz-preview__left__middle"}
      [:div {:class "ui hero-image"}
        [sprite "/img/monsters.png" (:x monster) (:y monster)]]]
     [:div {:class "ui hz-preview__left__bottom"}]]
    [:div {:class "hz-preview__right"}
     [:div {:class "ui hz-preview__right__top"}]
     [:div {:class "ui hz-preview__right__middle"}
      [:div {:class "hz-preview__level"}
       [widgets/level (:level monster)]]
      [:div
        [:strong (:name monster)]]
      [:hr]
      [button [:span [icon "attack"] "Hunt"]]
     [:div {:class "ui hz-preview__right__bottom"}]]]]))

(defn monsters-list [monsters]
  [:div {:class "monsters-list"}
   (map-indexed monster-preview monsters)])

(defn main []
  [:main
   [widgets/navbar "Hunt"]
   [monsters-list (state/get :monsters)]
   [widgets/action-bar]])

