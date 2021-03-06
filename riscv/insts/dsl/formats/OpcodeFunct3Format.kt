package venusbackend.riscv.insts.dsl.formats

import venusbackend.riscv.InstructionField

open class OpcodeFunct3Format(opcode: Int, funct3: Int) : InstructionFormat(4, listOf(
        FieldEqual(InstructionField.OPCODE, opcode),
        FieldEqual(InstructionField.FUNCT3, funct3)
))
