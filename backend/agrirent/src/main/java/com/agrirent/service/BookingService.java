package com.agrirent.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.agrirent.dto.BookingDto;
import com.agrirent.entity.Booking;
import com.agrirent.entity.Machine;
import com.agrirent.entity.Status;
import com.agrirent.entity.User;
import com.agrirent.repository.BookingRepository;
import com.agrirent.repository.MachineRepository;
import com.agrirent.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final UserRepository userRepository;
    private final MachineRepository machineRepository;
    private final BookingRepository bookingRepository;

   public BookingDto makeBooking(
        BookingDto bookingDto,
        User user) {

        Machine machine = machineRepository
            .findById(bookingDto.getMachineId())
            .orElseThrow(() ->
                    new RuntimeException("Machine not found"));

        Booking booking = Booking.builder()
            .user(user)
            .machine(machine)
            .booking_type(bookingDto.getBookingType())
            .startDate(bookingDto.getStartDate())
            .endDate(bookingDto.getEndDate())
            .startTime(bookingDto.getStartTime())
            .endTime(bookingDto.getEndTime())
            .status(Status.PENDING)
            .build();

        bookingRepository.save(booking);

        return bookingDto;
    }

    public List<BookingDto> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(booking -> BookingDto.builder()
                        .machineId(booking.getMachine().getId())
                        .bookingType(booking.getBooking_type())
                        .startDate(booking.getStartDate())
                        .endDate(booking.getEndDate())
                        .startTime(booking.getStartTime())
                        .endTime(booking.getEndTime())
                        .build())
                .collect(Collectors.toList());
    }

    public BookingDto getBookingById(Long id) {
        return bookingRepository.findById(id)
                .map(booking -> BookingDto.builder()
                        .machineId(booking.getMachine().getId())
                        .bookingType(booking.getBooking_type())
                        .startDate(booking.getStartDate())
                        .endDate(booking.getEndDate())
                        .startTime(booking.getStartTime())
                        .endTime(booking.getEndTime())
                        .build())
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }


    public BookingDto updateBooking(Long id, BookingDto bookingDto) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setBooking_type(bookingDto.getBookingType());
        booking.setStartDate(bookingDto.getStartDate());
        booking.setEndDate(bookingDto.getEndDate());
        booking.setStartTime(bookingDto.getStartTime());
        booking.setEndTime(bookingDto.getEndTime());
        booking = bookingRepository.save(booking);
        return BookingDto.builder()
                .machineId(booking.getMachine().getId())
                .bookingType(booking.getBooking_type())
                .startDate(booking.getStartDate())
                .endDate(booking.getEndDate())
                .startTime(booking.getStartTime())
                .endTime(booking.getEndTime())
                .build();
    }

    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        bookingRepository.delete(booking);
    }
}
