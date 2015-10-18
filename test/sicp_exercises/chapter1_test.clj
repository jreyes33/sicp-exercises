(ns sicp-exercises.chapter1-test
  (:require [clojure.test :refer :all]
            [sicp-exercises.chapter1 :refer :all]))

(deftest test-sum-of-squares-of-largest
  (is (= 13 (sum-of-squares-of-largest 1 2 3)))
  (is (= 41 (sum-of-squares-of-largest 4 5 3)))
  (is (= 18 (sum-of-squares-of-largest 3 2 3))))

(deftest test-better-sqrt
  (is (= "90000.00" (format "%.2f" (better-sqrt 8100000000))))
  (is (= "0.000500" (format "%.6f" (better-sqrt 0.00000025)))))

(deftest test-cube-root
  (is (= "3.00" (format "%.2f" (cube-root 27))))
  (is (= "75.00" (format "%.2f" (cube-root 421875))))
  (is (= "0.0500" (format "%.4f" (cube-root 0.000125)))))
