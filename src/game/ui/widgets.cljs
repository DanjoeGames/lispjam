(ns game.ui.widgets
  (:require [game.util.core :as util]))

(defn button
  "Creates a button and passes props down to child
   elements. Also takes text and an optional color
   where color is red, blue, green, yellow"
  [text props color]
    (let [color (or color "default")
          css-class (str "btn" " " "btn--" color)]
      [:div (merge props {:class css-class})
        [:div {:class "ui btn__left"}]
        [:div {:class "ui btn__middle"} text]
        [:div {:class "ui btn__right"}]]))

(defn icon
  "Wrapper around generic icon type uses the appropriate
   CSS class and attaches a given suffix in order to
   style as an icon"
  [icon-name]
    [:div {:class (str "icon" " " icon-name)}])

(defn xp-orb
  "Renders a full/empty xp orb icon depending on full?"
  [full?]
    [icon (if full? "xp-orb--full" "xp-orb--empty")])

(defn xp-bar
  "Renders an XP bar of with y orbs. x orbs will
   be coloured and the rest will be empty."
  [x y]
    [:div {:class "icon-bar"}
     [:strong "XP"]
     (->> (repeat x true) (map xp-orb))
     (->> (repeat (- y x) false) (map xp-orb))])

(defn heart
  "Renders a full/empty heart icon depending on full?"
  [full?]
    [icon (if full? "heart--full" "heart--empty")])

(defn hp-bar
  "Renders an HP bar of with y hearts. x hearts will
   be coloured and the rest will be empty."
  [x y]
    [:div {:class "icon-bar"}
     [:strong "HP"]
     (->> (repeat x true) (map heart))
     (->> (repeat (- y x) false) (map heart))])

(defn money
  "Renders money with the appropriate color and suffix"
  [x]
    (let [amount (condp < x
                   1000000 "amount--huge"
                   100000 "amount--large"
                   10000 "amount--big"
                   "amount--small")]
      [:span {:title (str x " gold")}
        [icon "gold"]
        [:strong {:class amount} (util/money-suffix x)]]))

(defn navbar
  "Renders a navbar and accepts children to be rendered
   inside it"
  [& children]
    [:nav {:class "ui navbar"}
     children])

