(ns game.ui.hero
  (:refer-clojure :exclude [list])
  (:require [game.ui.widgets :as widgets]
            [game.ui.item :as item]))

(defn nametag
  "Renders the level and name of a hero, expects a hero
   map as an argument."
  [hero]
    [:div {:class "ui hero-preview__nametag"}
     [:span {:class "hero-preview__nametag__level"} (:level hero)]
     [:span {:class "hero-preview__nametag__name"} (:name hero)]])

(defn image
  "Renders an image representation of a hero. Expects
   a hero map as an argument."
  [hero]
    [:div {:class "ui hero-image"}
      [:img {:src "/img/man.png"}]])

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
        [item/slots (:items hero) 6]]
      [:div {:class "ui hero-footer"}]])

(defn list
  "Renders a list of heroes from a seq/vector of
   hero maps"
  [heroes]
    [:div {:class "hero-list"}
     [:h3 "Your Heroes"]
     (map preview heroes)])

