(ns game.ui.item)

(defn slot
  "Renders an empty item slot"
  [item]
    [:div {:class "ui item-slot"}])

(defn slots
  "Renders empty item slots based on a seq/vector of items"
  [items len]
    [:div {:class "item-slots" }
      (map slot (repeat len :key))])

