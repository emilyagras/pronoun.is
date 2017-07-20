(ns pronouns.pages-test
  (:require [pronouns.pages :as pages]
            [clojure.test :refer :all]
            [midje.sweet :refer :all]))

(fact "prose-comma-list turns a list of strings into a prose list with commas"
      (pages/prose-comma-list ["foo"]) => "foo"
      (pages/prose-comma-list ["foo" "bar"]) => "foo and bar"
      (pages/prose-comma-list ["foo" "bar" "baz"]) => "foo, bar, and baz"
      (pages/prose-comma-list ["foo" "bar" "baz" "bobble"]) => "foo, bar, baz, and bobble"
      (pages/prose-comma-list []) => "")

(deftest pronouns
  (testing "lol literally nothing"
    (with-redefs  [pages/pronouns (fn  [args]  args )]
          (is  (not  (= "1234" (  pages/pronouns "99999"   )  )))
          (is  (= "1234" (  pages/pronouns "1234"   )  ))))
;  (testing "lol literally again "
;    (with-redefs  [pages/format-pronoun-examples
;                   (fn  [& args]  args )]
;          (is  (= 1234 ( pages/pronouns {:* "they" "x" "y", "foo" "bar"})))))
  )
