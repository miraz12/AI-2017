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
	(:init 	(adjacent room-1 room-2) (adjacent room-2 room-3)
		(shakey-at s1 room-2) (box-in box-1 room-1)
		(box-fits-door room-1 room-2) (box-fits-door room-2 room-3)
)
	(:goal (box-in box-1 room-3))
)
