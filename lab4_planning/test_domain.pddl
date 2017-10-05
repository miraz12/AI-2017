(define (domain TEST_DOMAIN)
  (:requirements :strips :equality :typing :adl)
  (:types
	shakey
	room 
	object 
	box 
	gripper)
  (:predicates
	(adjacent	?r1  ?r2 - room)		; Can move from ?l1 directly to ?l2
	(room-lit	?r - room)			; Is room lit?

	(shakey-at	?s - shakey ?r - room)		; shakey ?s is at room ?r
	(object-at	?o - object ?r - room)		; object ?o is at room ?r

	(holding	?g - gripper ?o - object)	; gripper ?g is holding object ?o
	(empty		?k - gripper)			; gripper ?g is not holding anything
  )
