(ns game.views.hunt
  (:require [reagent.core :as reagent]
            [secretary.core :refer [dispatch!]]
            [game.state :as state]
            [game.ui.widgets :as widgets :refer [button icon overlay]]
            [game.ui.item :as item]
            [game.ui.hero :refer [sprite]]
            [game.util.hero :refer [id->hero]]
            [game.battle :as battle]))

(defn action-bar []
  [:div {:class "ui action-bar"}
   [button "Heroes" {:on-click #(dispatch! "/heroes")} "yellow"]
   [button "League" {:on-click #(dispatch! "/league")} "blue"]
   [button "Shop"   {:on-click #(dispatch! "/shop")} "green"]])

(defn attack-button [monster]
  (let [showing? (reagent/atom false)
        show! #(reset! showing? true)
        hide! #(reset! showing? false)]
      [button [:span [icon "attack"] "Hunt"] 
       {:on-click #(println (battle/resolveBattle (map id->hero (state/get :player-heroes)) monster))}]))
    ;[overlay ;{:showing? @showing?}
    ; [:p ((battle/resolveBattle (map id->hero (state/get :player-heroes)) monster) :winner)  ]]))

(defn monster-preview
 ([monster]
  (monster-preview nil monster))
 ([k monster]
   [:div {:key k
          :class "hz-preview"}
    [:div {:class "hz-preview__left"}
     [:div {:class "ui hz-preview__left__top"}]
     [:div {:class "ui hz-preview__left__middle"}
      [:div {:class "hero-image"}
        [sprite "/img/monsters.png" (:x monster) (:y monster)]]]
     [:div {:class "ui hz-preview__left__bottom"}]]
    [:div {:class "hz-preview__right"}
     [:div {:class "ui hz-preview__right__top"}]
     [:div {:class "ui hz-preview__right__middle"}
      [:div {:class "hz-preview__level"}
       [widgets/level (:level monster)]]
      [:div
        [:strong (:name monster)]
        [:p {:class "faded"}
         (get monster :desc "No description")]]
      [:hr]
     (attack-button monster)]
     [:div {:class "ui hz-preview__right__bottom"}]]]))

(defn monsters-list [monsters]
  [:div {:class "monsters-list"}
   (map-indexed monster-preview monsters)])

(defn main []
  [:main
   [widgets/navbar "Hunt"]
   [monsters-list (state/get :monsters)]
   [widgets/action-bar]])

