(ns sicp-exercises.chapter1)

;; 1.1
;; Use the repl to evaluate the expressions. Look out for these expressions
;; that have to be translated from Scheme to Clojure:
;; (def a 3)
;; (def b (+ a 1))
;; (cond (= a 4) 6
;;       (= b 4) (+ 6 7 a)
;;       :else 25)
;; (* (cond (> a b) a
;;          (< a b) b
;;          :else -1)
;;    (+ a 1))


;; 1.2
(/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
   (* 3 (- 6 2) (- 2 7)))

;; 1.3
(defn sum-of-squares-of-largest [x y z]
  (apply + (map #(* % %)
                (take 2 (reverse (sort [x y z]))))))

;; 1.4
;; The if call will return either the addition or substraction functions,
;; depending on the value of b.

;; 1.5
;; With normal-order evaluation the result is 0. With applicative-order
;; evaluating p is infinitely recursive.

;; 1.6
;; Evaluating the recursive sqrt-iter causes an overflow.

;; 1.7
;; Example with a small number:
;; (sqrt 0.000025) should be 0.005 but it outputs 0.031515954454847304
;; Can't find a good example of failure with a large number, it may be
;; Clojure data type that handles larger numbers better than Scheme.
(defn good-enough? [guess x]
  (< (Math/abs (- (* guess guess) x)) 0.001))

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

(defn better-good-enough? [last-guess guess x]
  (< (/ (Math/abs (- guess last-guess)) guess) 0.00001))

(defn better-sqrt-iter [last-guess guess x]
  (if (better-good-enough? last-guess guess x)
    guess
    (better-sqrt-iter guess (improve guess x) x)))

(defn better-sqrt [x]
  (better-sqrt-iter 0.0 1.0 x))

;; 1.8
(defn improve-cube-root [guess x]
  (/ (+ (/ x (* guess guess)) (* 2 guess)) 3))

(defn cube-root-iter [last-guess guess x]
  (if (better-good-enough? last-guess guess x)
    guess
    (cube-root-iter guess (improve-cube-root guess x) x)))

(defn cube-root [x]
  (cube-root-iter 0.0 1.0 x))
