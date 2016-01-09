(ns game.battle)

(defn b2i [b] 
  (case b
    true 1
    false 0))

(defn getHeroStrength [hero]
  (case (:role hero) 
    "attack" (* (* (:strength (:weapon hero)) 2) (:level hero))
    "defence" (* (:strength (:weapon hero)) (:level hero))))

(defn getHeroToughness [hero]
  (case (hero :role) 
    "attack" (* (:defence (:armor hero)) (:level hero))
    "defence" (* (* (:defence (:armor hero)) 2) (:level hero))))

(defn getMonsterStrength [monster]
  (* (:strength (:weapon monster)) (:level monster)))

(defn getMonsterToughness [monster]
  (* (:defence (:armor monster)) (:level monster)))

(defn calculatePartyStrength [party] 
  (reduce + (map (fn [hero] (getHeroStrength hero)) party)))

(defn calculatePartyToughness [party] 
  (reduce + (map (fn [hero] (getHeroToughness hero)) party)))

(defn resolveDamage [attack toughness] 
  (let [diff (- attack toughness)
        effective (b2i (> diff 0))]
    (*  (+ diff (rand-int diff)) effective)))

(defn calculatePartyHP [party]
  (reduce + (map (fn [hero] (:hp hero)) party)))

(defn hpPercentageParty [party damage]
  (* (/ (calculatePartyHP party) 100) damage))

(defn hpPercentageMonster [monster damage]
  (* (/ (:hp monster) 100) damage))

(defn resolveBattle [party monster]
  (let [monsterDamage 
        (resolveDamage (calculatePartyStrength party) (getMonsterToughness monster))
        partyDamage
        (resolveDamage (getMonsterStrength monster) (calculatePartyToughness party))]
    (case (> monsterDamage
             partyDamage)
      true {:winner "party" 
            :damageTaken partyDamage :damageDealt monsterDamage} 
      false {:winner "monster" 
             :damageTaken partyDamage :damageDealt monsterDamage})))


