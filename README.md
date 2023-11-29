# ShippingSystem
The CA exercise aims at creating a Java shipping management system that heavily utilizes custom-built internal data structures. The system should enable users to manage a fleet of container ships, whether at sea or docked at numerous ports.
All ports can handle many container ships. Each container ship can hold many containers. Every container can be aboard a ship or “on shore” at a port.
Each container holds many pallets. A pallet holds one product. To summarize, commodities must be stored on a pallet, the pallet in a container, the container on a ship, and the ship either docked or at sea.

![image](https://github.com/michaelo223/ShippingSystem/assets/91596967/55027003-a000-4596-97dd-90bca24948b8)
![image](https://github.com/michaelo223/ShippingSystem/assets/91596967/4331b8df-1813-4e06-8233-13d064c6cc95)

# Asignment Brief
* Add a new port to the system. The following information should be stored for each port: port name, international port code (must be unique), and country. Each port should be able to accommodate “on shore” storage of containers.
* Add a new container ship to a port. The following information should be stored for each container ship: ship name, ship identifier (IMO or similar; must be unique), flag state (country of registration), and photograph (as a URL).
* Add a container to either (1) a (docked) container ship, or (2) to a port (i.e. stored “on shore”
at the port). Properties that should be stored for each container: container number or
alphanumeric identifier (must be unique), and container size (10, 20 or 40 feet long; assume
8 feet width and height).
* Add a pallet of goods to a container (either in a container ship or in a port). Pallets should
have properties: description of goods, the number/quantity of them on the pallet, unit
value, total weight, and total size (in cubic feet).
** Note that you should not allow more pallets in a container than it could hold based
on the container’s size. For example, a 10 foot-long container can hold 8x8x10=640
cubic feet in total, so don’t allow a combination of pallets that exceeds this (ignore
the shape, etc. of goods/cargo).
* Load and unload existing containers to/from a container ship and its current port.
* Launch and dock container ships. Ships at a port can launch to be “at sea”, and “at sea”
ships can dock at a port.
* View all container ship locations. Show the locations of all container ships using a port-byport (and “at sea”) structured view.
* Provide a structured view of all goods in the shipping system. This would show/list all goods
on all pallets in all containers in all container ships and ports (including ships “at sea” and
containers stored “on shore”).
* Provide a structured valuation of all goods in the system. This will show the total values of
goods by (1) overall system, (2) port (total; all containers on ship, and all containers “on
2
shore”), (3) container ship, (4) container, and (5) pallet. The value of a given pallet will be
the unit price multiplied by the quantity.
* Interactively “drill down” through ports, container ships, containers and pallets to view all
goods stored on ships or “on shore” using an appropriate GUI.
* Search for goods by name. The system will systematically search for all pallets of the given
good and report on where they are stored and their quantities, unit values, etc.
* A “smart add” facility for pallets of goods. Given the good’s description, quantity, unit value,
size, etc., the system will identify a “suitable” container to store them at a specified port
(either on a container ship or “on shore” at the port). It completes the “smart add” by
creating and adding a pallet to the identified container and reporting on the storage details
(container identifier, location, etc.)
** You can have the “smart add” behave any way you think appropriate. For instance,
keeping expensive goods together, or goods with similar names together, etc.
* Remove pallets of goods from a container. Specified pallets removed from specified
containers are simply discarded.
* Reset facility. Clears all system data.
* Save and load the entire system data to support persistence between executions.
* This can be done using any suitable file format (e.g. CSV, XML, binary, etc.). There is
no need to use any database system beyond this.
* Other appropriate facilities to manage the shipping system as you see fit.
** Do not deviate too far from the marking scheme, though, as I cannot offer extra
marks for unasked for features as everyone must be assessed by the same rubric.
