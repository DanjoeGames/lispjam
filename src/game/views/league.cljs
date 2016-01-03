(ns game.views.league
  (:require [reagent.core :as reagent]
            [secretary.core :refer [dispatch!]]
            [game.state :as state]
            [game.ui.hero :as hero]
            [game.ui.widgets :as widgets :refer [button icon pill]]
            [game.ui.item :as item]))

(defn table-entry [hero]
  [widgets/horizontal-preview
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
     [button [widgets/money 300]]]]])

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
     [{:name "Medusa"  :level 65 :xp 3 :hp 1}
      {:name "Orix"    :level 39 :xp 5 :hp 2}
      {:name "Orix"    :level 4 :xp 2 :hp 3}
      {:name "Orix"    :level -1 :xp 2 :hp 4}
      {:name "Centaur" :level 12 :xp 5 :hp 5}]]
   [widgets/action-bar]])

