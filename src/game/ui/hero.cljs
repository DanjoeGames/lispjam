(ns game.ui.hero)

(defn nametag [hero]
  [:span {:class (if (:legendary hero)
                   "hero__nametag--legendary"
                   "hero__nametag--regular")}
   (:name hero)])

(defn level [hero]
  [:span (:level hero)])

