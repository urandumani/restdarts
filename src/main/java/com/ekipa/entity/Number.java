package com.ekipa.entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ekipa.entity.Game.GameStatus;

@Table(name = "number")
public class Number {
	
	public enum Hit {
        ZERO(0), ONE(1), TWO(2), THREE(3);

        private int value;

        private Hit(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
        
        public static Hit parse(int id) {
        	Hit hit = null;
            for (Hit item : Hit.values()) {
                if (item.getValue()==id) {
                	hit = item;
                    break;
                }
            }
            return hit;
        }
    };
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "times_hit")
    private int timesHit;

	public Long getId() {
		return id;
	}
	
	public Hit getHit () {
        return Hit.parse(this.timesHit);
    }

    public void setHit(Hit hit) {
        this.timesHit = hit.getValue();
    }
}