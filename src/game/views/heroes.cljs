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

(defn navbar [& children]
  [:nav {:class "ui navbar"}
   children])

(defn hero-nametag [hero]
  [:div {:class "ui hero-preview__nametag"}
   [:span {:class "hero-preview__nametag__level"} (:level hero)]
   [:span {:class "hero-preview__nametag__name"} (:name hero)]])

(defn hero-image [hero]
  [:div {:class "ui hero-image"}
    [:img {:src "/img/man.png"}]])

(defn xp-orb [full?]
  [:div {:class (if full? "icon xp-orb--full" "icon xp-orb--empty")}])

(defn xp-bar [xp len]
  [:div
   [:strong "XP"]
   (->> (repeat xp true) (map xp-orb))
   (->> (repeat (- len xp) false) (map xp-orb))])

(defn heart [full?]
  [:div {:class (if full? "icon heart--full" "icon heart--empty")}])

(defn hp-bar [hp len]
  [:div
   [:strong "HP"]
   (->> (repeat hp true) (map heart))
   (->> (repeat (- len hp) false) (map heart))])

(defn item-slot [item]
  [:div {:class "ui item-slot"}])

(defn item-slots [items len]
  [:div {:class "item-slots" }
    (map item-slot (repeat len :key))])

(defn hero-preview [hero]
  [:div {:class "hero-preview"}
    [hero-nametag hero]
    [hero-image hero]
    [:div {:class "ui hero-image__footer"}]
    [:div {:class "ui hero-panel"}
      [hp-bar (:hp hero) 5]
      [xp-bar (:xp hero) 5]
      [item-slots (:items hero) 6]]
    [:div {:class "ui hero-footer"}]])

(defn action-bar []
  [:div {:class "action-bar"}
   [button "Hunt" {:on-click #(dispatch! "/hunt")} "red"]
   [button "League" {:on-click #(dispatch! "/league")} "blue"]
   [button "Shop" {:on-click #(dispatch! "/hunt")} "yellow"]])

;; TODO erghh. needs a refactor
(defn money-suffix [x]
  (let [m10 10000000
        k100 100000]
  (condp <= x
    m10  (str (js/parseFloat (.toFixed (/ x 1000000) 2)) "M")
    k100 (str (js/parseFloat (.toFixed (/ x 1000) 2)) "K")
    x)))

(defn money [x]
  (let [amount (condp < x
                 1000000 "amount--huge"
                 100000 "amount--large"
                 10000 "amount--big"
                 "amount--small")]
    [:span {:title (str x " gold")}
      [:div {:class "icon gold"}]
      [:strong {:class amount} (money-suffix x)]]))

(defn hero-list [heroes]
  [:div {:class "hero-list"}
   [:h3 "Your Heroes"]
   (map hero-preview heroes)])

(defn main []
  [:main
   [navbar
    [money 110044]
    [:strong "Heroes For Hire"]]
   [hero-list [
               {:name "Dan" :level 9 :xp 3 :hp 4 :items []}
               {:name "Ed" :level 2 :xp 2 :hp 5 :items []}
               {:name "Joe" :level 19 :xp 5 :hp 3 :items []}]]
   [action-bar]])

