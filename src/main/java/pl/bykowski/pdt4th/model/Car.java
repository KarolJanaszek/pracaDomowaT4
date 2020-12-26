package pl.bykowski.pdt4th.model;

import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class Car extends ResourceSupport {
    private long id;

    @NotNull
    @Size(min = 3)
    private String mark;

    @NotNull
    @Size(min = 3)
    private String model;

    @NotNull
    private Color color;

    private LocalDate prodDate;

    public Car() {
    }

    public Car(String mark, String model, Color color) {
        this.mark = mark;
        this.model = model;
        this.color = color;
    }

    public Car(long id, @NotNull @Size(min = 3) String mark, @NotNull @Size(min = 3) String model, @NotNull Color color, LocalDate prodDate) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.prodDate = prodDate;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public long getCarId() {
        return id;
    }

    public void setCarId(long id) {
        this.id = id;
    }

    public String getProdDate() {
        if (prodDate != null) {
            return prodDate.toString();
        } else {
            return null;
        }
    }

    public void setProdDate(String prodDate) {
        if (prodDate == null || prodDate.isEmpty()) {
            this.prodDate = LocalDate.parse("1900-01-01");
        } else {
            this.prodDate = LocalDate.parse(prodDate);
        }
    }

//        public LocalDate getProdDate() {
//          return prodDate;
//        }
//
//        public void setProdDate(LocalDate prodDate) {
//          this.prodDate = prodDate;
//        }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", color=" + color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
