(define (domain TEST_DOMAIN)
(:requirements :strips :equality :typing :adl)
(:types
	shakey
	room
	object
	box
	gripper)
	
(:predicates
	(adjacent	?r1  ?r2 - room)		; can move from ?l1 directly to ?l2
	(room-lit	?r - room)			; room is lit
	(box-fits-door	?r1 ?r2 - room)		; a box can be moved from ?r1 to ?r
	(box-in-pos	?b - box ?r - room)		; a box is placed under the switch	
	
	(shakey-at	?s - shakey ?r - room)		; shakey ?s is at room ?r
	(holding	?g - gripper ?o - object)	; gripper ?g is holding object ?o
	(empty		?k - gripper)			; gripper ?g is not holding anything
	
	(object-in	?o - object ?r - room)		; object ?o is in room ?r
	
	(box-in		?b - box ?r - room)		; box ?b is in room ?r
  )

(:action move                                
	:parameters (?s - shakey ?from ?to - room)

	:precondition (and 
		(adjacent ?from ?to)
		(shakey-at ?s ?from)
	)

	:effect (and 
		(shakey-at ?s ?to)
		(not (shakey-at ?s ?from))
	)
)

 (:action pick-up
	:parameters(?s - shakey ?o - object ?g - gripper ?r - room)
	:precondition(and
		(shakey-at ?s ?r)
		(object-in ?o ?r)
		(room-lit ?r)
		(empty ?g)
	)
	:effect(and
		(not (empty ?g))
		(holding ?g ?o)
		(not (object-in ?o ?r))
	)
 )

 (:action drop
	:parameters(?s - shakey ?o - object ?g - gripper ?r - room)
	:precondition(and
		(shakey-at ?s ?r)
		(holding ?g ?o)
	)
	:effect(and
		(empty ?g)
		(not (holding ?g ?o))
		(object-in ?o ?r)
	)
 )

 (:action move-box-in-position
	:parameters(?s - shakey ?b - box ?r - room)
	:precondition(and
		(shakey-at ?s ?r)
		(not(box-in-pos ?b ?r))
	)
	:effect(and
		(box-in-pos ?b ?r)
	)
 )
 
 (:action light-on
	:parameters(?s - shakey ?b - box?r - room)
	:precondition(and
		(shakey-at ?s ?r)
		(box-in-pos ?b ?r)
		(not(room-lit ?r))
	)
	:effect(and
		(room-lit ?r)
	)
 )

(:action push
	:parameters(?s - shakey ?b - box ?from ?to - room)
	:precondition(and
		(shakey-at ?s ?from)
		(box-fits-door ?from ?to)
		(box-in ?b ?from)
	)
	:effect(and
		(shakey-at ?s ?to)
		(not(shakey-at ?s ?from))
		(box-in ?b ?to)
		(not(box-in ?b ?from))
	)
 )
)




