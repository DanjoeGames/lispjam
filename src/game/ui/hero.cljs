(ns game.ui.hero
  (:refer-clojure :exclude [list])
  (:require [secretary.core :refer [dispatch!]]
            [game.ui.widgets :as widgets :refer [button icon]]
            [game.ui.item :as item]))

(defn nametag
  "Renders the level and name of a hero, expects a hero
   map as an argument."
  [hero]
    [:div {:class "ui hero-preview__nametag"}
     [:span {:class "hero-preview__nametag__level"}
      [widgets/level (:level hero)]]
     [:span {:class "hero-preview__nametag__name"} (:name hero)]])

(defn sprite
 ([url x y]
  (sprite url x y 0 0))
 ([url x y dx dy]
   (let [s 96
         sf 8
         rx (- (.round js/Math (* x s)))
         ry (- (.round js/Math (* y s)))]
     [:div {:class "sprite"
            :style {:background-image (str "url(" url ")")
                    :background-position (str rx "px " ry "px")
                    :left (.ceil js/Math (* dx sf))
                    :top (.ceil js/Math (* dy sf))
                    :display "inline-block"
                    :width s
                    :height s}}])))

(defn image
  "Renders an image representation of a hero. Expects
   a hero map as an argument."
  [{skin :skin
    hair :hair
    clothes :clothes
    weapon :weapon
    headgear :headgear
    armor :armor}]
    [:div {:class "hero-image"}
     [sprite "/img/heroes.png" (:x skin) (:y skin)]
     [sprite "/img/heroes.png" (:x clothes) (:y clothes)]
     [sprite "/img/heroes.png" (:x hair) (:y hair)]
     (when armor    [sprite "img/items.png" (:x armor) (:y armor) 1 1])
     (when headgear [sprite "img/items.png" (:x headgear) (:y headgear) 1 -2])
     (when weapon   [sprite "img/items.png" (:x weapon) (:y weapon) -3 -1])])

(defn preview
  "Renders a complete preview of a hero, expects a
   hero map as an argument."
 [id hero]
   [:div {:key id
          :class "hero-preview"}
     [nametag hero]
     [:div {:class "hero-background"}
       [image hero]]
     [:div {:class "ui hero-image__footer"}]
     [:div {:class "ui hero-panel"}
       [widgets/hp-bar (:hp hero) 5]
       [widgets/xp-bar (:xp hero) 5]
       [:br]
       [item/slots (:items hero) 3]]
     [:div {:class "ui hero-footer"}]
     [:div
      [widgets/cycler
       [button [icon "attack"] nil "red"]
       [button [icon "defend"] nil "blue"]
       [button [icon "sleep"]]]
      [button [icon "potion"] nil]
      [button [icon "quit"]]]])

(defn list
  "Renders a list of heroes from a seq/vector of
   hero maps"
  [heroes]
    [:div {:class "hero-list"}
     (if (empty? heroes)
       [:section
        [:h3 "You don't own any heroes!"]
        [:p "Head to the league table to buy some."]
        [button
         "League"
         {:color "blue" :on-click #(dispatch! "/league")}]]
       (map-indexed preview heroes))])

