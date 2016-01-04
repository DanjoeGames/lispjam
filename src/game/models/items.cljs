(ns game.models.items)

(def weapons
  [{:x 0, :y 0, :name "Iron Sword", :type :weapon}])

(def headgear
  [{:x 1, :y 0, :name "Iron Helmet", :type :weapon}])

(def armor
  [{:x 2, :y 0, :name "Leather Armor", :type :weapon}])

(def all
  (concat weapons
          headgear
          armor))

