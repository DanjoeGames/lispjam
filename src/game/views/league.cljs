(ns game.views.league
  (:require [reagent.core :as reagent]
            [secretary.core :refer [dispatch!]]
            [game.state :as state]
            [game.ui.hero :as hero]
            [game.ui.widgets :as widgets :refer [button icon pill]]
            [game.ui.item :as item]
            [game.util.player :as player]))

(defn buy-hero-button
  [hero]
  (let [showing-confirm? (reagent/atom false)
        show-confirm #(reset! showing-confirm? false)
        hide-confirm #(reset! showing-confirm? true)]
    (fn []
      [:div
       [button
        [:div "Hire for " [widgets/money (:cost hero)]]
        {:on-click #(player/buy-hero! (:id hero))}]])))

;; TODO refactor
(defn table-entry
 [hero]
   [:div {:key (:id hero)
          :class "hz-preview"}
    [:div {:class "hz-preview__left"}
     [:div {:class "ui hz-preview__left__top"}]
     [:div {:class "ui hz-preview__left__middle"}
      [:div {:class "hero-image"}
       [hero/image hero]]]
     [:div {:class "ui hz-preview__left__bottom"}]]
    [:div {:class "hz-preview__right"}
     [:div {:class "ui hz-preview__right__top"}]
     [:div {:class "ui hz-preview__right__middle"}
      [:div {:class "hz-preview__level"}
       [widgets/level (:level hero)]]
      [:strong (:name hero)]
      [:hr]
      (cond
        (player/owns-hero? (:id hero)) [:strong "Purchased"]
        (player/has-enough-gold? (:cost hero)) [buy-hero-button hero]
        :else [widgets/money (:cost hero)])]
     [:div {:class "ui hz-preview__right__bottom"}]]])

(defn assign-id [id m] (assoc m :id id))

(defn league-table [heroes]
  (let [reversed? (reagent/atom true)
        sort-ascend #(reset! reversed? false)
        sort-descend #(reset! reversed? true)
        reverser #(if @reversed? (reverse %) %)]
    (fn []
      [:div {:class "league-table"}
       [widgets/cycler
        [button
         [:div [icon "ascending"] "Sort"]
         {:on-click sort-ascend}]
        [button
         [:div [icon "descending"] "Sort"]
         {:on-click sort-descend}]]
       [:div
         (->> heroes
              (map-indexed assign-id)
              (sort-by :level)
              (reverser)
              (map table-entry))]])))

(defn main []
  [:main
   [widgets/navbar "League"]
   [league-table (state/get :heroes)]
   [widgets/action-bar]])

