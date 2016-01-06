(ns game.models.monsters)

(def all
  [{:type :demon, :x 0, :y 0, :level 5 :name "Small Demon", :desc "Not a big demon"}
   {:type :demon, :x 1, :y 0, :level 10 :name "Demon", :desc ""}

   {:type :monk, :x 2, :y 0, :level 10 :name "Monk", :desc "A hooded chap"}
   {:type :monk, :x 3, :y 0, :level 20 :name "Monk"}
   {:type :monk, :x 4, :y 0, :level 30 :name "Monk"}
   {:type :monk, :x 5, :y 0, :level 40 :name "Monk"}

   {:type :dragon, :x 0, :y 1, :level 50 :name "Dragon", :desc "A green scaled dragon"}
   {:type :dragon, :x 1, :y 1, :level 60 :name "Dragon", :desc "A blue scaled dragon"}
   {:type :dragon, :x 2, :y 1, :level 75 :name "Dragon", :desc "A purple scaled dragon"}
   {:type :dragon, :x 3, :y 1, :level 80 :name "Dragon", :desc "A huge red scaled dragon"}
   {:type :dragon, :x 4, :y 1, :level 90 :name "Dragon", :desc "An enormous black scaled dragon"}

   {:type :egypt, :x 0, :y 2, :level 100 :name "Horus"}
   {:type :egypt, :x 1, :y 2, :level 100 :name "Sobek"}
   {:type :egypt, :x 2, :y 2, :level 100 :name "Anubis"}
   {:type :egypt, :x 3, :y 2, :level 100 :name "Osiris"}
   {:type :egypt, :x 4, :y 2, :level 100 :name "Isis"}

   {:type :jungle, :x 0, :y 3, :level 10 :name "Jungle Snake"}
   {:type :jungle, :x 1, :y 3, :level 20 :name "Jungle Scorpion"}
   {:type :jungle, :x 2, :y 3, :level 30 :name "Jungle Stinger"}
   {:type :jungle, :x 3, :y 3, :level 40 :name "Jungle Greatshell"}
   {:type :jungle, :x 4, :y 3, :level 50 :name "Jungle Spirit"}
   {:type :jungle, :x 4, :y 3, :level 90 :name "Jungle God"}

   {:type :cave, :x 0, :y 4, :level 10 :name "Cave Gobbler"}
   {:type :cave, :x 1, :y 4, :level 20 :name "Cave Grub"}
   {:type :cave, :x 2, :y 4, :level 30 :name "Cave Watcher"}
   {:type :cave, :x 3, :y 4, :level 40 :name "Cave Goblin"}
   {:type :cave, :x 4, :y 4, :level 50 :name "Cave Knight"}
   {:type :cave, :x 5, :y 4, :level 60 :name "Cave Knight"}
   {:type :cave, :x 6, :y 4, :level 70 :name "Cave Troll"}
   {:type :cave, :x 7, :y 4, :level 80 :name "Cave Troll"}
   {:type :cave, :x 8, :y 4, :level 90 :name "Cave Troll Captain"}
   {:type :cave, :x 9, :y 4, :level 100 :name "Cave Troll King"}

   {:type :snow, :x 0, :y 5, :level 40 :name "Snow Spider"}
   {:type :snow, :x 1, :y 5, :level 50 :name "Snow Spirit"}
   {:type :snow, :x 2, :y 5, :level 60 :name "Yeti"}
   {:type :snow, :x 3, :y 5, :level 70 :name "Yeti"}

   {:type :molten, :x 0, :y 6, :level 40 :name "Fire Mote"}
   {:type :molten, :x 1, :y 6, :level 50 :name "Molten Fiend"}
   {:type :molten, :x 2, :y 6, :level 60 :name "Molten Crawler"}
   {:type :molten, :x 3, :y 6, :level 70 :name "Molten Giant"}
   {:type :molten, :x 4, :y 6, :level 100 :name "Molten God"}

   {:type :undead, :x 0, :y 7, :level 10 :name "Skeleton Child"}
   {:type :undead, :x 1, :y 7, :level 20 :name "Skeleton"}
   {:type :undead, :x 2, :y 7, :level 30 :name "Skeleton Mage"}
   {:type :undead, :x 3, :y 7, :level 60 :name "Skeleton Commander"}
   {:type :undead, :x 4, :y 7, :level 80 :name "Skeleton King"}
   {:type :undead, :x 5, :y 7, :level 90 :name "Lich Priest"}
   {:type :undead, :x 6, :y 7, :level 100 :name "Wraith King"}

   {:type :chaos, :x 0, :y 8, :level 50 :name "Chaos Denizen"}
   {:type :chaos, :x 1, :y 8, :level 50 :name "Chaos Denizen"}
   {:type :chaos, :x 2, :y 8, :level 50 :name "Chaos Denizen"}
   {:type :chaos, :x 3, :y 8, :level 50 :name "Chaos Denizen"}
   {:type :chaos, :x 4, :y 8, :level 50 :name "Chaos Denizen"}
   {:type :chaos, :x 5, :y 8, :level 90 :name "Chaos Summoner"}
   {:type :chaos, :x 6, :y 8, :level 100 :name "Chaos Lord"}])


