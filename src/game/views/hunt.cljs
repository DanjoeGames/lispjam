(ns game.views.hunt
  (:require
            [game.ui.widgets :as widgets :refer [button icon]]
            [game.ui.item :as item]))

(defn dispatch! [st])

(defn action-bar []
  [:div {:class "ui action-bar"}
   [button "Heroes" {:on-click #(dispatch! "/heroes")} "yellow"]
   [button "League" {:on-click #(dispatch! "/league")} "blue"]
   [button "Shop"   {:on-click #(dispatch! "/shop")} "green"]])

(defn monster-preview
 ([monster]
  (monster-preview nil monster))
 ([k monster]
   [:div {:key k}
    [widgets/horizontal-preview
     [:div {:class "hz-preview__level"}
      [widgets/level (:level monster)]]
     [:div [:strong (:name monster)]]
     [item/slots [] 3]
     [button [:span [icon "attack"] "Hunt"]]]]))

(defn monsters-list [monsters]
  [:div {:class "monsters-list"}
   (map-indexed monster-preview monsters)])

(defn main []
  [:main
   [widgets/navbar "Hunt"]
   [monsters-list []]
   [widgets/action-bar]])

