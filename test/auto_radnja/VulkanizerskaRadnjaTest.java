package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VulkanizerskaRadnjaTest extends RadnjaTest{

	@Override
	protected Radnja getInstance() {
		return new VulkanizerskaRadnja();
	}

	

}
