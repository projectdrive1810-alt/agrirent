# Database design
Database : PostgreSql

Purpose : store user, machine, booking data

## Entities : User(Entity)

            id BigInt PK,
            username varchar(50) unique,
            password varchar(255),
            email varchar(100) unique,
            phone varchar(10) unique,
            role enum( user , admin),
            created_at timestamp

        : Machine(Entity)

            id BigInt PK,
            machine_name varchar,
            machine_type varchar,
            owner_id BigInt FK -> users.id,
            daily_rental_price decimal,
            hourly_rental_price decimal,
            location text,
            is_available boolean,
            created_at timestamp

        : MachineImages(Entity)
            id BigInt PK
            machine_id BigInt FK -> machines.id
            image_url TEXT

        : Booking(Entity)

            id BigInt PK,
            user_id BigInt FK -> users.id,
            machine_id BigInt FK -> machines.id,
            booking_type enum('hourly', 'daily'),
            start_date date,
            end_date date,
            start_time time,
            end_time time,
            total_amount decimal,
            status enum( pending , approved , rejected , active , completed ),
            created_at timestamp

## Relationships

User (Owner) 1 -> N Machine

User (Farmer) 1 -> N Booking

Machine 1 -> N Booking

Machine 1 -> N MachineImages

## Future Enhancements

Review
Notification
Payment
Admin