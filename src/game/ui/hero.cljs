(ns game.ui.hero
  (:refer-clojure :exclude [list])
  (:require [game.ui.widgets :as widgets :refer [button icon]]
            [game.ui.item :as item]))

(defn nametag
  "Renders the level and name of a hero, expects a hero
   map as an argument."
  [hero]
    [:div {:class "ui hero-preview__nametag"}
     [:span {:class "hero-preview__nametag__level"}
      [widgets/level (:level hero)]]
     [:span {:class "hero-preview__nametag__name"} (:name hero)]])

(defn sprite [url x y]
  (let [s 100
        rx (- (.round js/Math (* x s)))
        ry (- (.round js/Math (* y s)))]
    [:div {:class "sprite"
           :style {:background-image (str "url(" url ")")
                   :background-position (str rx "px " ry "px")
                   :display "inline-block"
                   :width s
                   :height s}}]))

(defn image
  "Renders an image representation of a hero. Expects
   a hero map as an argument."
  [{skin :skin hair :hair clothes :clothes}]
    [:div {:class "ui hero-image"}
     [sprite "/img/heroes.png" (:x skin) (:y skin)]
     [sprite "/img/heroes.png" (:x clothes) (:y clothes)]
     [sprite "/img/heroes.png" (:x hair) (:y hair)]
     ])

(defn preview
  "Renders a complete preview of a hero, expects a
   hero map as an argument."
  [hero]
    [:div {:class "hero-preview"}
      [nametag hero]
      [image hero]
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
       [button [icon "potion"] nil]]])

(defn list
  "Renders a list of heroes from a seq/vector of
   hero maps"
  [heroes]
    [:div {:class "hero-list"}
     (map preview heroes)])

