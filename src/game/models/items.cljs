(ns game.models.items)

(def weapons
  [{:x 0, :y 2, :name "Rusty Sword", :type :weapon, :strength 1}
   {:x 1, :y 2, :name "Iron Sword", :type :weapon, :strength 2}
   {:x 2, :y 2, :name "Steel Sword", :type :weapon, :strength 3}
   {:x 3, :y 2, :name "Greensteel Sword", :type :weapon, :strength 5}
   {:x 4, :y 2, :name "Cobalt Sword", :type :weapon, :strength 8}
   {:x 5, :y 2, :name "Gold Sword", :type :weapon, :strength 10}
   {:x 6, :y 2, :name "Jungle Sword", :type :weapon, :strength 15}
   {:x 7, :y 2, :name "Cave Sword", :type :weapon, :strength 15}
   {:x 8, :y 2, :name "Chaos Sword", :type :weapon, :strength 15}
   {:x 0, :y 3, :name "Iron Spear", :type :weapon, :strength 4}
   {:x 1, :y 3, :name "Stone Hammer", :type :weapon, :strength 10}
   {:x 2, :y 3, :name "Gold Hammer", :type :weapon, :strength 20}
   {:x 3, :y 3, :name "Lich Staff", :type :weapon, :strength 20}
   {:x 4, :y 3, :name "Ankh", :type :weapon, :strength 20}
   {:x 5, :y 3, :name "Gold Dagger", :type :weapon, :strength 8}
   {:x 6, :y 3, :name "Jungle Dagger", :type :weapon, :strength 10}
   {:x 7, :y 3, :name "Cave Dagger", :type :weapon, :strength 10}
   {:x 8, :y 3, :name "Chaos Dagger", :type :weapon, :strength 10}
   {:x 0, :y 4, :name "Spellbook", :type :weapon, :strength 5}
   {:x 1, :y 4, :name "Starbook", :type :weapon, :strength 10}
   {:x 2, :y 4, :name "Wealthbook", :type :weapon, :strength 10}
   {:x 3, :y 4, :name "Lifebook", :type :weapon, :strength 10}])

;; headgear
(def headgear
  [{:x 0, :y 5, :name "Leather Cap", :type :headgear, :defense 1}
   {:x 1, :y 5, :name "Iron Helm", :type :headgear, :defense 2}
   {:x 2, :y 5, :name "Steel Helm", :type :headgear, :defense 3}
   {:x 3, :y 5, :name "Greensteel Helm", :type :headgear, :defense 5}
   {:x 4, :y 5, :name "Cobalt Helm", :type :headgear, :defense 8}
   {:x 5, :y 5, :name "Gold Helm", :type :headgear, :defense 10}
   {:x 6, :y 5, :name "Jungle Helm", :type :headgear, :defense 15}
   {:x 7, :y 5, :name "Cave Helm", :type :headgear, :defense 15}
   {:x 8, :y 5, :name "Molten Helm", :type :headgear, :defense 15}
   {:x 0, :y 6, :name "Green Dragonhide Coif", :type :headgear, :defense 10}
   {:x 1, :y 6, :name "Blue Dragonhide Coif", :type :headgear, :defense 11}
   {:x 2, :y 6, :name "Purple Cave Helm", :type :headgear, :defense 12}
   {:x 3, :y 6, :name "Red Dragonhide Coif", :type :headgear, :defense 13}
   {:x 4, :y 6, :name "Black Cave Helm", :type :headgear, :defense 14}
   {:x 5, :y 6, :name "Jester Hat", :type :headgear, :defense 5}
   {:x 0, :y 7, :name "Green Hood", :type :headgear, :defense 5}
   {:x 1, :y 7, :name "Purple Hood", :type :headgear, :defense 6}
   {:x 2, :y 7, :name "Black Hood", :type :headgear, :defense 7}
   {:x 3, :y 7, :name "Red Hood", :type :headgear, :defense 8}])

;; armor
(def armor
  [{:x 0, :y 8, :name "Leather Armor", :type :armor, :defense 1}
   {:x 1, :y 8, :name "Iron Armor", :type :armor, :defense 2}
   {:x 2, :y 8, :name "Steel Armor", :type :armor, :defense 3}
   {:x 3, :y 8, :name "Greensteel Armor", :type :armor, :defense 5}
   {:x 4, :y 8, :name "Cobalt Armor", :type :armor, :defense 8}
   {:x 5, :y 8, :name "Gold Armor", :type :armor, :defense 10}
   {:x 6, :y 8, :name "Jungle Armor", :type :armor, :defense 15}
   {:x 7, :y 8, :name "Cave Armor", :type :armor, :defense 15}
   {:x 8, :y 8, :name "Molten Armor", :type :armor, :defense 15}
   {:x 9, :y 8, :name "Chaos Armor", :type :armor, :defense 20}
   {:x 0, :y 9, :name "Green Dragonhide", :type :armor, :defense 10}
   {:x 1, :y 9, :name "Blue Dragonhide", :type :armor, :defense 11}
   {:x 2, :y 9, :name "Purple Dragonhide", :type :armor, :defense 12}
   {:x 3, :y 9, :name "Red Dragonhide", :type :armor, :defense 13}
   {:x 4, :y 9, :name "Black Dragonhide", :type :armor, :defense 14}])

(def potions
  [{:x 0, :y 0, :name "Small Red Potion", :type :potion}
   {:x 1, :y 0, :name "Small Green Potion", :type :potion}
   {:x 2, :y 0, :name "Small Purple Potion", :type :potion}
   {:x 3, :y 0, :name "Small Yellow Potion", :type :potion}
   {:x 4, :y 0, :name "Small Blue Potion", :type :potion}
   {:x 5, :y 0, :name "Big Red Potion", :type :potion}
   {:x 6, :y 0, :name "Big Green Potion", :type :potion}
   {:x 7, :y 0, :name "Big Yellow Potion", :type :potion}
   {:x 8, :y 0, :name "Big Purple Potion", :type :potion}
   {:x 5, :y 1, :name "1/2 Red Potion", :type :potion}
   {:x 6, :y 1, :name "1/2 Green Potion", :type :potion}
   {:x 7, :y 1, :name "1/2 Yellow Potion", :type :potion}
   {:x 8, :y 1, :name "1/2 Purple Potion", :type :potion}])

(def all
  (concat weapons
          headgear
          armor
          potions))

