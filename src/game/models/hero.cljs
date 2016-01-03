(ns game.models.hero)

(def skins
  {:male [{:x 0 :y 0 :titles []}
          {:x 2 :y 0 :titles ["of the East"]}
          {:x 4 :y 0 :titles ["of the South"]}
          {:x 6 :y 0 :titles ["the Goblin"]}
          {:x 8 :y 0 :titles ["the Orc"]}]
   :female [{:x 1 :y 0 :titles []}
            {:x 3 :y 0 :titles ["of the East"]}
            {:x 5 :y 0 :titles ["of the South"]}
            {:x 7 :y 0 :titles ["the Goblin"]}
            {:x 9 :y 0 :titles ["the Orc"]}]})

(def hair
  {:male [{:x 0 :y 1 :titles ["the Brown"]}
          {:x 1 :y 1 :titles ["the Elder"]}
          {:x 2 :y 1 :titles ["the Ginger"]}
          {:x 3 :y 1 :titles ["the Fair"]}
          {:x 4 :y 1 :titles ["the Blue"]}
          {:x 5 :y 1 :titles ["the Holy"]}
          {:x 6 :y 1 :titles ["the Tribal"]}
          {:x 7 :y 1 :titles ["the Tribal"]}
          {:x 8 :y 1 :titles ["the Sad"]}
          {:x 9 :y 1 :titles []}]
   :female [{:x 0 :y 2 :titles ["the Brown"]}
            {:x 1 :y 2 :titles ["the Elder"]}
            {:x 2 :y 2 :titles ["the Ginger"]}
            {:x 3 :y 2 :titles ["the Fair"]}
            {:x 4 :y 2 :titles ["the Blue"]}
            {:x 5 :y 2 :titles ["the Holy"]}
            {:x 6 :y 2 :titles ["the Tribal"]}
            {:x 7 :y 2 :titles ["the Tribal"]}
            {:x 8 :y 2 :titles ["the Sad"]}
            {:x 9 :y 2 :titles []}]})

(def clothes
  {:male [{:x 0 :y 3 :titles []}
          {:x 1 :y 3 :titles []}
          {:x 2 :y 3 :titles []}
          {:x 3 :y 3 :titles []}
          {:x 4 :y 3 :titles []}
          {:x 5 :y 3 :titles []}
          {:x 6 :y 3 :titles []}
          {:x 7 :y 3 :titles []}
          {:x 8 :y 3 :titles []}
          {:x 9 :y 3 :titles []}]
   :female [{:x 0 :y 4 :titles []}
            {:x 1 :y 4 :titles []}
            {:x 2 :y 4 :titles []}
            {:x 3 :y 4 :titles []}
            {:x 4 :y 4 :titles []}
            {:x 5 :y 4 :titles []}
            {:x 6 :y 4 :titles []}
            {:x 7 :y 4 :titles []}
            {:x 8 :y 4 :titles []}
            {:x 9 :y 4 :titles []}]})

