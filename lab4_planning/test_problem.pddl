(define (problem TEST_PROBLEM)
	(:domain TEST_DOMAIN)
	(:objects 
		s1 - shakey 
		room-1 room-2 room-3 - room
		;;light-switch-1 light-switch-2 light-switch-3 ??
		box-1 - box
		g1 g2 - gripper
		o1 o2 - object
)
	(:init 	(adjacent room-1 room-2) (adjacent room-2 room-3) (adjacent room-2 room-1) (adjacent room-3 room-2)
		(shakey-at s1 room-2) (box-in box-1 room-1)
		(box-fits-door room-1 room-2) (box-fits-door room-2 room-3) (box-fits-door room-2 room-1) (box-fits-door room-3 room-2)
		(empty g1) (empty g2)
		(object-in o1 room-1) (object-in o2 room-2)
)
	(:goal (box-in box-1 room-3))
)
