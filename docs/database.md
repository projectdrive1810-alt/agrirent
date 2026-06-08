# Database design
Database : PostgreSql

Purpose : store user, machine, booking data

## Entities : User(Entity)

            id BigInt,
            username varchar,
            password varchar,
            email varchar,
            phone varchar,
            role enum,
            created_at timestamp
            
        
        : Machine(Entity)

            id BigInt,
            machine_name varchar,
            machine_type varchar,
            owner_id BigInt,
            daily_rental_price decimal,
            hourly_rental_price decimal,
            location text,
            is_available boolean,
            created_at timestamp



        : Booking(Entity)

            id BigInt,
            user_id BigInt,
            machine_id BigInt,
            start_date date,
            end_date date,
            total_amount decimal,
            status enum,
            created_at timestamp

## Relationships

User (Owner) 1 -> N Machine

User (Farmer) 1 -> N Booking

Machine 1 -> N Booking


## Future Enhancements

Review
Notification
Payment
Admin