(ns sicp-clj.scheme)

(defn car [x]
  (first x))

(defn cdr [x]
  (rest x))

(defn cadr [x]
  (car (cdr x)))

(defn caddr [x]
  (car (cdr (cdr x))))

(defn pair? [x]
  (and (seq? x) (> (count x) 1)))

(defn eq? [x y]
  (= x y))

(defn equal? [x y]
  (if (and (pair? x) (pair? y))
    (and (equal? (car x) (car y)) (equal? (cdr x) (cdr y)))
    (eq? x y)))

(defn expt [x n]
  (if (zero? n)
    1
    (* x (expt x (dec n)))))
