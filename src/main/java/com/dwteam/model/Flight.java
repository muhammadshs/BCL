package com.dwteam.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
    private Date dateOfFlight;
    private Date departureTime;
    private Date arrivalTime,newArrivalTime;
    private Date flightDuration;
    private Date departureTimeWithDelay;
    private Double distanceTravelled;
    private Integer delay;
    private String departureAirport,departureCity,arrivalAirport,arrivalCity,flightNumber,airline;

    public Flight(String dateOfFlight, String departureTime, String arrivalTime, String flightDuration, String distanceTravelled, String delay, String departureAirport, String departureCity, String arrivalAirport, String arrivalCity, String flightNumber, String airline) {
        setDateOfFlight(dateOfFlight);
        setDepartureTime(dateOfFlight,departureTime);
        setArrivalTime(dateOfFlight,arrivalTime);
        setFlightDuration(dateOfFlight,flightDuration);
        setDistanceTravelled(distanceTravelled);
        setDelay(delay);
        this.departureAirport = departureAirport;
        this.departureCity = departureCity;
        this.arrivalAirport = arrivalAirport;
        this.arrivalCity = arrivalCity;
        this.flightNumber = flightNumber;
        this.airline = airline;
        setNewArrivalTime(dateOfFlight,arrivalTime);
        setDepartureTimeWithDelay(dateOfFlight,departureTime);
    }

    public Date getDepartureTimeWithDelay() {
        return departureTimeWithDelay;
    }

    public void setDepartureTimeWithDelay(String dOF,String departureTime) {
        String[] split=departureTime.toString().split(":");
        Integer i=Integer.parseInt(split[1])+delay;
        Integer h=Integer.parseInt(split[0]);
        if(i%60>0){
            h=h+(i/60);
            i=i%60;
        }
        String s=h+":"+i;
        try {
            this.departureTimeWithDelay = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(dOF+" "+s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getNewArrivalTime() {
        return newArrivalTime;
    }

    public void setNewArrivalTime(String dOF,String arrivalTime) {
        String[] split=arrivalTime.toString().split(":");
        Integer i=Integer.parseInt(split[1])+delay;
        Integer h=Integer.parseInt(split[0]);
        if(i%60>0){
            h=h+(i/60);
            i=i%60;
        }
        String s=h+":"+i;
        try {
            this.newArrivalTime = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(dOF+" "+s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    public String getDepartureTimeWithDelayString(){

        return new SimpleDateFormat("hh:mm").format(getDepartureTime());
    }
    public Date getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(String dateOfFlight) {

        try {
            this.dateOfFlight = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfFlight);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String dOF,String departureTime) {
        try {
            this.departureTime = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(dOF+" "+departureTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public String getDepartureTimeString(){

        return new SimpleDateFormat("hh:mm").format(getDepartureTime());
    }
    public String getArrivalTimeString(){

        return new SimpleDateFormat("hh:mm").format(getArrivalTime());
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String dOF,String arrivalTime) {
        try {
            this.arrivalTime = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(dOF+" "+arrivalTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(String dOF,String flightDuration) {
        try {
            this.flightDuration = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(dOF+" "+flightDuration);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public String getFlightDurationString(){

        return new SimpleDateFormat("hh:mm").format(getFlightDuration());
    }
    public Double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(String distanceTravelled) {
        this.distanceTravelled = Double.parseDouble(distanceTravelled);
    }
    public String getNewArrivalTimeString(){

        return new SimpleDateFormat("hh:mm").format(getNewArrivalTime());
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay =Integer.parseInt(delay) ;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "dateOfFlight=" + dateOfFlight +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", newArrivalTime=" + newArrivalTime +
                ", flightDuration=" + flightDuration +
                ", distanceTravelled=" + distanceTravelled +
                ", delay=" + delay +
                ", departureAirport='" + departureAirport + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", airline='" + airline + '\'' +
                '}';
    }
}
