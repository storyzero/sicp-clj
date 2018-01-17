(ns sicp-clj.p273
  (:require [sicp-clj.scheme :refer :all]))

(defn variable? [x]
  (symbol? x))

(defn same-variable? [x y]
  (and (variable? x)
       (variable? y)
       (eq? x y)))

(defn operator [x]
  (car x))

(defn operands [x]
  (cdr x))

(defn make-sum [x y]
  (list '+ x y))

(defn make-product [x y]
  (list '* x y))

(defn augend [x]
  (cadr x))

(defn addend [x]
  (caddr x))

(defn multiplicand [x]
  (cadr x))

(defn multiplier [x]
  (caddr x))


(defn deriv [exp var]
  (cond (number? exp) 0
        (variable? exp) (if (same-variable? exp var) 1 0)
        :else (((operator exp) deriv-map) (operands exp) var)))

(defn deriv-sum [exp var]
  (make-sum (deriv (addend exp) var) (deriv (augend exp) var)))

(defn deriv-product [exp var]
  (make-sum (make-product (multiplier exp)
                          (deriv (multiplicand exp) var))
            (make-product (deriv (multiplier exp) var)
                          (multiplicand exp))))

(def deriv-map
  {'+ deriv-sum
   '* deriv-product})

(def soluation-a
  "표현식의 연산자에 따라 그에 알맞은 프로시저를 실행한다.
  number? 와 variable? 은 연산자를 데이터로 사용하지 않기 때문에 함께 데이터 중심 방식으로 다루지 못한다.")

(def solution-b
  {'+ deriv-sum
   '* deriv-product})

(def solution-c
  "???")

(def sloution-d
  "???")