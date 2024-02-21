| ====================================================================
| === NE PAS MODIFIER
| ====================================================================
    nop
	nop
	nop
	nop
	nop
	nop
	nop
	nop
	bra .epilogue

	.globl	get_bricks_layout
    .type   get_bricks_layout, @function
get_bricks_layout:
    movem.l %d0-%d7/%a0-%a6,-(%sp)
    move.w 66(%sp),nb_bricks
	bra .begin
	
.epilogue:	
    move.l 68(%sp),%a0
	move.w 66(%sp),%d0
    lea    id_bricks,%a1
	bra .L2
.L1:
	move.w (%a1)+,(%a0)+
	subi.w #1,%d0 
.L2:
    cmpi.w #0,%d0
	bgt    .L1	

	movem.l (%sp)+,%d0-%d7/%a0-%a6
    rts
