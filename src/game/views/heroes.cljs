(ns game.views.heroes
  (:require [reagent.core :as reagent]
            [secretary.core :refer [dispatch!]]))

(defn button [text props color]
  (let [color (or color "default")
        css-class (str "btn" " " "btn--" color)]
    [:div (merge {:class css-class} props)
      [:div {:class "ui btn__left"}]
      [:div {:class "ui btn__middle"} text]
      [:div {:class "ui btn__right"}]]))

(defn main []
  [:main
   [button "Hunt" {:on-click #(dispatch! "/hunt")} "red"]
   [button "League" {:on-click #(dispatch! "/league")} "blue"]])

