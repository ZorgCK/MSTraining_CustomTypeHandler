package domain;

import java.time.Instant;

import one.microstream.persistence.binary.types.Binary;
import one.microstream.persistence.binary.types.BinaryTypeHandler;


public class Timeslot
{
	private int		slotID;
	private Instant	from;
	private Instant	to;
	
	public Integer getSlotID()
	{
		return slotID;
	}
	
	public void setSlotID(Integer slotID)
	{
		this.slotID = slotID;
	}
	
	public Instant getFrom()
	{
		return from;
	}
	
	public void setFrom(Instant from)
	{
		this.from = from;
	}
	
	public Instant getTo()
	{
		return to;
	}
	
	public void setTo(Instant to)
	{
		this.to = to;
	}
	
	static BinaryTypeHandler<Timeslot> handleType()
	{
		//@formatter:off
		return Binary.TypeHandler(
			Timeslot.class,
			Binary.Field_int("slotID", slot -> slot.slotID, (slot, value) -> slot.slotID = value),
			Binary.Field_long("from", slot -> slot.from.toEpochMilli(), (slot, value) -> slot.from = Instant.ofEpochMilli(value)),
			Binary.Field_long("to", slot -> slot.to.toEpochMilli(), (slot, value) -> slot.to = Instant.ofEpochMilli(value))
		);
	}

}
