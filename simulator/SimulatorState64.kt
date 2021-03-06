package venusbackend.simulator

import venusbackend.riscv.MemorySegments
import venusbackend.riscv.insts.floating.Decimal
import venusbackend.simulator.cache.CacheHandler

class SimulatorState64 : SimulatorState {
    /*Register 32 is the special register.*/
    private val regs64 = Array(33) { 0.toLong() }
    private val fregs = Array(33) { Decimal() }
    private var pc: Long = 0
    private var maxpc: Long = MemorySegments.TEXT_BEGIN.toLong()
    private var heapEnd = MemorySegments.HEAP_BEGIN.toLong()

    override val registerWidth = 64
    override var mem = Memory()
    override var cache = CacheHandler(1)
    override fun setCacheHandler(ch: CacheHandler) {
        cache = ch
    }
    override fun setPC(location: Number) {
        this.pc = location.toLong()
    }
    override fun getPC(): Number {
        return this.pc
    }
    override fun incPC(amount: Number) {
        this.pc += amount.toLong()
    }
    override fun setMaxPC(location: Number) {
        this.maxpc = location.toLong()
    }
    override fun getMaxPC(): Number {
        return this.maxpc
    }
    override fun incMaxPC(amount: Number) {
        this.maxpc = (this.maxpc + amount.toLong())
    }
    override fun getReg(i: Int) = regs64[i]
    override fun setReg(i: Int, v: Number) { if (i != 0) regs64[i] = v.toLong() }
    override fun getFReg(i: Int) = fregs[i]
    override fun setFReg(i: Int, v: Decimal) { fregs[i] = v }
    override fun getHeapEnd(): Number {
        return heapEnd
    }

    override fun setHeapEnd(i: Number) {
        heapEnd = i.toLong()
    }

    override fun incHeapEnd(amount: Number) {
        heapEnd += amount.toLong()
    }

    override fun reset() {
        this.cache.reset()
    }
}
