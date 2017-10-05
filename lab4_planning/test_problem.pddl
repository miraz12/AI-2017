(define (problem TEST_PROBLEM)
	(:domain TEST_DOMAIN)
	(:objects shakey room-1 room-2 room-3
		;;door-1 door-2 door-3
		light-switch-1 light-switch-2 light-switch-3
		box
)
	(:init 	(adjecent room-1 room-2) (adjecent room-2 room-3)
		(shakey-at shakey room-2) (box-in-pos box room-1)
		(box-fits-door room-1 room-2) (box-fits-door room-2 room-3)
)
	(:goal (box-in box room-3))
)
