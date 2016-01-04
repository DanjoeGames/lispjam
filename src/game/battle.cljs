(ns game.battle)

(defn b2i [b] 
  (case b
    true 1
    false 0))

(defn getHeroStrength [hero]
  (case (hero :role) 
    "attack" (* (* (hero :attack) 2) (hero :level))
    "defence" (* (hero :attack) (hero :level))))

(defn getHeroToughness [hero]
  (case (hero :role) 
    "attack" (* (hero :toughness) (hero :level))
    "defence" (* (* (hero :toughness) 2) (hero :level))))

(defn getMonsterStrength [monster]
  (* (monster :attack) (monster :level)))

(defn getMonsterToughness [monster]
  (* (monster :toughness) (monster :level)))

(defn calculatePartyStrength [party] 
  (reduce + (map (fn [hero] (getHeroStrength hero)) party)))

(defn calculatePartyToughness [party] 
  (reduce + (map (fn [hero] (getHeroToughness hero)) party)))

(defn resolveDamage [attack toughness] 
  (let [diff (- attack toughness)
        effective (b2i (> diff 0))]
    (*  (+ diff (rand-int (/ diff 2))) effective)))

(defn calculatePartyHP [party]
  (reduce + (map (fn [hero] (hero :hp)) party)))

(defn hpPercentageParty [party damage]
  (* (/ (calculatePartyHP party) 100) damage))

(defn hpPercentageMonster [monster damage]
  (* (/ (monster :hp) 100) damage))

(defn resolveBattle [party monster]
  (let [monsterDamage 
        (resolveDamage (calculatePartyStrength party) (getMonsterToughness monster))
        partyDamage
        (resolveDamage (getMonsterStrength monster) (calculatePartyToughness party))]
    (case (> (hpPercentageMonster monster monsterDamage) 
             (hpPercentageParty party partyDamage))
      true {:winner "party" 
            :damageTaken partyDamage :damageDealt monsterDamage} 
      false {:winner "monster" 
             :damageTaken partyDamage :damageDealt monsterDamage})))


