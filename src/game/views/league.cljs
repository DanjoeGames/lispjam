(ns game.views.league
  (:require [reagent.core :as reagent]
            [secretary.core :refer [dispatch!]]
            [game.state :as state]
            [game.ui.hero :as hero]
            [game.ui.widgets :as widgets :refer [button icon pill]]
            [game.ui.item :as item]
            [game.procedural.hero :refer [generate]]))

;; TODO refactor
(defn table-entry
 ([hero]
  (table-entry nil hero))
 ([k hero]
   [:div {:key k
          :class "hz-preview"}
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
      [:hr]
      [button
       [:div "Hire for " [widgets/money (:cost hero)]]]
      [widgets/overlay {:showing? false}
       [widgets/scroll
        [:h2 "Do you want to purchase this hero?"]
        [:hr]
        [button "Cancel" nil "red"]
        [button [widgets/money 300]]]]]
     [:div {:class "ui hz-preview__right__bottom"}]]]))

(defn league-table [heroes]
  (let [reversed? (reagent/atom true)
        sort-ascend #(reset! reversed? false)
        sort-descend #(reset! reversed? true)
        reverser #(if @reversed? (reverse %) %)
        show-dead? (reagent/atom true)
        toggle-dead #(swap! show-dead? not)]
    (fn []
      [:div {:class "league-table"}
       [widgets/cycler
        [button
         [:div [icon "ascending"] "Sort"]
         {:on-click sort-ascend}]
        [button
         [:div [icon "descending"] "Sort"]
         {:on-click sort-descend :color "blue"}]]
       [widgets/cycler
        [button
         [:div [icon "skull"] "Show Dead"]
         {:on-click toggle-dead}]
        [button
         [:div [icon "skull"] "Hide Dead"]
         {:on-click toggle-dead :color "red"}]]
       [:div
         (->> heroes
              (sort-by :level)
              (reverser)
              (map-indexed table-entry))]])))

(defn main []
  [:main
   [widgets/navbar "League"]
   [league-table (state/get :heroes)]
   [widgets/action-bar]])

