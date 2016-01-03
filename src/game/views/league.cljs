(ns game.views.league
  (:require [reagent.core :as reagent]
            [secretary.core :refer [dispatch!]]
            [game.state :as state]
            [game.ui.hero :as hero]
            [game.ui.widgets :as widgets :refer [button icon pill]]
            [game.ui.item :as item]
            [game.procedural.hero :refer [generate]]))

(defn table-entry [hero]
  [:div {:class "hz-preview"}
   [:div {:class "hz-preview__left"}
    [:div {:class "ui hz-preview__left__top"}]
    [:div {:class "ui hz-preview__left__middle"}
     [hero/image hero]]
    [:div {:class "ui hz-preview__left__bottom"}]]
   [:div {:class "hz-preview__right"}
    [:div {:class "ui hz-preview__right__top"}]
    [:div {:class "ui hz-preview__right__middle"}
     [:div {:class "hz-preview__level"}
      [widgets/level (:level hero)]]
     [:strong (:name hero)]
     [button
      [:div "Hire for " [widgets/money 3000001]]]
     [widgets/overlay {:showing? false}
      [widgets/scroll
       [:h2 "Do you want to purchase this hero?"]
       [:hr]
       [button "Cancel" nil "red"]
       [button [widgets/money 300]]]]]
    [:div {:class "ui hz-preview__right__bottom"}]]])

(defn league-table [heroes]
  [:div {:class "league-table"}
   (->> heroes
        (sort-by :level)
        (reverse)
        (map table-entry))])

(defn main []
  [:main
   [widgets/navbar "League"]
   [league-table
    (map generate (range 10))]
   [widgets/action-bar]])

