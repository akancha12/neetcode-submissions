class Solution {
    class Car{
        Integer speed;
        Integer position;
        double time;
        Car(int speed, int position, int target) {
            this.speed = speed;
            this.position = position;
            this.setTime(target);
        }
        public void setTime(int target) {
            this.time = ((target - this.position) * 1.0) / this.speed;
        }
        public String toString() {
            return this.position + " " + this.time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i=0; i<position.length; i++) {
            cars.add(new Car(speed[i], position[i], target));
        }
        cars.sort(new Comparator<>() {
            public int compare(Car c1, Car c2) {
                return c1.position.compareTo(c2.position);
            }
        });
        int result = 0;
        Stack<Car> stack = new Stack<>();
        for (int i=position.length-1; i>=0; i--) {
            Car current = cars.get(i);
            if (stack.isEmpty() || stack.peek().time < current.time) stack.push(current);
        }
        return stack.size();
    }
}
